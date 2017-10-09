import { Injectable } from '@angular/core';
import { Http }       from '@angular/http';
 
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
 
import { Book } from './book';
 
@Injectable()
export class BookSearchService {
 
  constructor(private http: Http) {}
 
  search(term: string): Observable<Book[]> {
    return this.http
              //  .get(`api/books/?title=${term}`) //changed '?name' to '?title'
               .get(`http://localhost:8081/EDU-Hibernate-JPA2-0.0.1-SNAPSHOT/book/title/${term}`) //changed '?name' to '?title'
               .map(response => response.json() as Book[]);
  }
}