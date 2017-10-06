import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Borrower } from './borrower';

@Injectable()
export class BorrowerService {

    private headers = new Headers({'Content-Type': 'application/json'});
    private borrowersUrl = 'http://localhost:8081/EDU-Hibernate-JPA2-0.0.1-SNAPSHOT/borrower/';

    constructor(private http: Http) {}

    getBorrowers(): Promise<Borrower[]> {
        return this.http.get(this.borrowersUrl)
            .toPromise()
            .then(response => response.json() as Borrower[])
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}