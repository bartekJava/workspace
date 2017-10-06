import 'rxjs/add/operator/switchMap';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import { BookService } from './book.service';
import { BorrowerService } from './borrower.service'
import { BorrowService } from './borrow.service'
import { Book } from './book';
import { Borrower } from './borrower';
import { Borrow } from './borrow';

@Component({
    selector: 'book-detail',
    templateUrl: './book-detail.component.html',
    styleUrls: [ './book-detail.component.css' ]
})
export class BookDetailComponent implements OnInit {

    book: Book;
    // borrower: string;
    borrower: Borrower;
    borrowers: Borrower[];
    borrow = new Borrow(undefined, undefined, undefined);

    constructor(
        private bookService: BookService,
        private borrowerService: BorrowerService,
        private borrowService: BorrowService,
        private route: ActivatedRoute,
        private location: Location
      ) {}

      ngOnInit(): void {
          this.route.paramMap
          .switchMap((params: ParamMap) => this.bookService.getBook(+params.get('id')))
          .subscribe(book => this.book = book);

          this.getBorrowers();
      }

      goBack(): void {
        this.location.back();
      }

      save(): void {
        // this.book.borrower = this.borrower;
        // this.bookService.update(this.book)
        //   .then(() => this.goBack());
        this.borrow.book = this.book;
        this.borrow.borrower = this.borrower;

        console.log(JSON.stringify(this.borrow))
        
        this.borrowService.create(this.borrow)
        .then(() => this.goBack());
        
      }

      getBorrowers(): void {
        this.borrowerService.getBorrowers().then(borrowers => this.borrowers = borrowers);
      }

      get bookDiagnostic() { return JSON.stringify(this.book); }
      get borrowerDiagnostic() { return JSON.stringify(this.borrower); }

}