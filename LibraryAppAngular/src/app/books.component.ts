import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Book } from './book';
import { Borrow } from './borrow';
import { BookService } from './book.service';
import { BorrowService } from './borrow.service';


@Component({
  selector: 'my-books',
  templateUrl: './books.component.html',
  styleUrls: [ './books.component.css' ]
})
export class BooksComponent implements OnInit {

  books: Book[];
  selectedBook: Book;
  borrows: Borrow[];
  borrowToDelete: Borrow;

  constructor(
    private router: Router, 
    private bookService: BookService,
    private borrowService: BorrowService
  ) {}


  ngOnInit(): void {
    this.getBooks()
    .then(
      () => this.getBorrows()
      .then(
        () => this.books.forEach(book => book.borrower = 
          (this.findBorrowsByBookId(book)) 
          ? (this.findBorrowsByBookId(book)).borrower.firstName + " " + (this.findBorrowsByBookId(book)).borrower.lastName 
          : "availible")
      )
    );
  }

  onSelect(book: Book): void {
    this.selectedBook = book;
  }

  getBooks(): Promise<Book[]> {
    return this.bookService.getBooks().then(books => this.books = books);
  }

  getBorrows(): Promise<void> {
    return this.borrowService.getBorrows().then(borrows => {
      this.borrows = borrows;
    });
  }

  findBorrowsByBookId(book): Borrow {
    return this.borrows.find(borrow => borrow.book.id === book.id);
  }

  edit(): void {
    this.router.navigate(['/create', this.selectedBook.id]);
  }

  delete(book: Book): void {
    this.borrowToDelete = this.borrows.find(borrow => borrow.book.id === book.id);
    console.log(JSON.stringify(this.borrowToDelete));
    if(this.borrowToDelete) {
      this.borrowService.delete(this.borrowToDelete.id)
      .then(() => {
        this.bookService.delete(book.id)
        .then(() => {
          this.books = this.books.filter(b => b !== book);
          if (this.selectedBook === book) { this.selectedBook = null; }
        });
      })
    } else {
      this.bookService.delete(book.id)
      .then(() => {
        this.books = this.books.filter(b => b !== book);
        if (this.selectedBook === book) { this.selectedBook = null; }
      });
    }
  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedBook.id ]);
  }

  gotoCreate(): void {
    this.router.navigate(['/create', 'new']);
  }

}
