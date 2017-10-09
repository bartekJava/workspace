import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule }     from './app-routing.module';

import { AppComponent } from './app.component';
import { BookDetailComponent } from './book-detail.component';
import { BooksComponent } from './books.component';
import { DashboardComponent } from './dashboard.component';
import { BookSearchComponent }  from './book-search.component';
import { BookCreationComponent }  from './book-creation.component';

import { BookService } from './book.service';
import { BorrowService } from './borrow.service'
import { AuthorService } from './author.service'
import { BorrowerService } from './borrower.service'

@NgModule({
  declarations: [
    AppComponent,
    BookDetailComponent,
    BooksComponent,
    DashboardComponent,
    BookSearchComponent,
    BookCreationComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule.forRoot(),
    AppRoutingModule
  ],
  providers: [ BookService, BorrowService, AuthorService, BorrowerService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
