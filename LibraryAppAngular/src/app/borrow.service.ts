import 'rxjs/add/operator/toPromise';

import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import { Borrow } from './borrow';

@Injectable()
export class BorrowService {

    private headers = new Headers({'Content-Type': 'application/json'});
    private borrowsUrl = 'http://localhost:8081/EDU-Hibernate-JPA2-0.0.1-SNAPSHOT/borrow/';

    constructor(private http: Http) {}

    getBorrows(): Promise<Borrow[]> {
        return this.http.get(this.borrowsUrl)
            .toPromise()
            .then(response => response.json() as Borrow[])
            .catch(this.handleError);
    }

    create(borrow: Borrow): Promise<Borrow> {
        return this.http
            .post(this.borrowsUrl, JSON.stringify(borrow), {headers: this.headers})
            .toPromise()
            .then(res => res.json() as Borrow)
            .catch(this.handleError);
    }

    delete(id: number): Promise<void> {
        const url = `${this.borrowsUrl}${id}`;
        return this.http.delete(url, {headers: this.headers})
          .toPromise()
          .then(() => null)
          .catch(this.handleError);
      }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}