import 'rxjs/add/operator/toPromise';

import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import { Author } from './author';

@Injectable()
export class AuthorService {

    private headers = new Headers({ 'Content-Type': 'application/json' });
    private authorsUrl = 'http://localhost:8081/EDU-Hibernate-JPA2-0.0.1-SNAPSHOT/author/';

    constructor(private http: Http) { }

    getAuthors(): Promise<Author[]> {
        return this.http.get(this.authorsUrl)
            .toPromise()
            .then(response => response.json() as Author[])
            .catch(this.handleError);
    }

    create(author: Author): Promise<Author> {
        return this.http
            .post(this.authorsUrl, JSON.stringify(author), { headers: this.headers })
            .toPromise()
            .then(res => res.json() as Author)
            .catch(this.handleError);
    }

    updateAuthor(author: Author): Promise<Author> {
        const url = `${this.authorsUrl}${author.id}`;
        return this.http
            .put(url, JSON.stringify(author), { headers: this.headers })
            .toPromise()
            .then(() => author)
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}