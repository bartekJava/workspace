import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Book } from './book';
import { Borrow } from './borrow';
import { BookService } from './book.service'
import { BorrowService } from './borrow.service'

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
  borrowedBooksIds: number[];

  constructor(
    private router: Router, 
    private bookService: BookService,
    private borrowService: BorrowService
  ) {}

  getBooks(): void {
    this.bookService.getBooks().then(books => this.books = books);
  }

  getBorrows(): void {
    this.borrowService.getBorrows().then(borrows => {
      this.borrows = borrows;
      this.borrowedBooksIds = this.borrows.map(borrow => borrow.book.id as number);
    });
  }

  ngOnInit(): void {
    this.getBooks();
    this.getBorrows();
  }

  onSelect(book: Book): void {
    this.selectedBook = book;
  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedBook.id]);
  }

  gotoCreate(): void {
    this.router.navigate(['/create']);
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

  // TODO: Remove this when we're done
  get selectedBookDiagnostic() { return JSON.stringify(this.selectedBook); }

  // add(title: string): void {
  //   title = title.trim();
  //   if (!title) { return; }
  //   this.bookService.create(title)
  //     .then(book => {
  //       this.books.push(book);
  //       this.selectedBook = null;
  //     });
  // }
}
