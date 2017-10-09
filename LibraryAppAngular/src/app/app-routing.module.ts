import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
import { BooksComponent }      from './books.component';
import { BookDetailComponent }  from './book-detail.component';
import { BookCreationComponent }  from './book-creation.component';
 
const routes: Routes = [
  { path: '', redirectTo: '/books', pathMatch: 'full' },
  { path: 'detail/:id', component: BookDetailComponent },
  { path: 'books',     component: BooksComponent },
  { path: 'create/:id',     component: BookCreationComponent }
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}