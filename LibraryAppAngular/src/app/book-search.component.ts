import { Component, OnInit } from '@angular/core';
import { Router }            from '@angular/router';
 
import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';
 
// Observable class extensions
import 'rxjs/add/observable/of';
 
// Observable operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';
 
import { BookSearchService } from './book-search.service';
import { Book } from './book';
 
@Component({
  selector: 'book-search',
  templateUrl: './book-search.component.html',
  styleUrls: [ './book-search.component.css' ],
  providers: [BookSearchService]
})
export class BookSearchComponent implements OnInit {
  books: Observable<Book[]>;
  private searchTerms = new Subject<string>();
 
  constructor(
    private bookSearchService: BookSearchService,
    private router: Router) {}
 
  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }
 
  ngOnInit(): void {
    this.books = this.searchTerms
      .debounceTime(300)        // wait 300ms after each keystroke before considering the term
      .distinctUntilChanged()   // ignore if next search term is same as previous
      .switchMap(term => term   // switch to new observable each time the term changes
        // return the http search observable
        ? this.bookSearchService.search(term)
        // or the observable of empty heroes if there was no search term
        : Observable.of<Book[]>([]))
      .catch(error => {
        // TODO: add real error handling
        console.log(error);
        return Observable.of<Book[]>([]);
      });
  }
 
  gotoDetail(book: Book): void {
    let link = ['/detail', book.id];
    this.router.navigate(link);
  }
}