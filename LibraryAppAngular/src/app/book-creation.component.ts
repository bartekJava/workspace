import 'rxjs/add/operator/switchMap';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute, ParamMap } from '@angular/router';

import { Book } from './book';
import { Author } from './author';
import { BookService } from './book.service'
import { AuthorService } from './author.service'

@Component({
    selector: 'book-creation',
    templateUrl: './book-creation.component.html',
    styleUrls: ['./book-creation.component.css']
})
export class BookCreationComponent implements OnInit{
    
    editMode = false;
    model = new Book(undefined, '', '', undefined, [], undefined, '', undefined);
    authors: Author[];
    selectedAuthor: Author;
    submitted = false;

    constructor(
        private router: Router, 
        private route: ActivatedRoute,
        private bookService: BookService,
        private authorService: AuthorService
      ) {}

    ngOnInit(): void {
        this.editMode = false;
        this.getAuthors();
        this.route.paramMap
        .switchMap((params: ParamMap) => this.bookService.getBook(+params.get('id')))
        .subscribe(
            book => {
                this.model = book
                console.log("flag switch")
                this.editMode = true;
            },
            error => this.editMode = false
        );
    }

    onSubmit() { 
        this.submitted = true;
        if(!this.editMode) {
            this.bookService.create(this.model);
        } else {
            this.bookService.update(this.model);
        }
    }

    getAuthors(): void {
        this.authorService.getAuthors().then(authors => this.authors = authors);
      }

    // TODO: Remove this when we're done
    get diagnostic() { return JSON.stringify(this.model); }
    get selectedAuthorDiagnostic() { return JSON.stringify(this.selectedAuthor); }

    newBook() {
        this.model = new Book(undefined, '', '', undefined, [], undefined, '', undefined);
        this.editMode = false;
    }

    gotoList(): void {
        this.router.navigate(['/books']);
    }

    genres = [
        {
            "id": 1,
            "type": "Drama"
        },
        {
            "id": 2,
            "type": "Tragedy"
        },
        {
            "id": 3,
            "type": "Comedy"
        },
        {
            "id": 4,
            "type": "Horror"
        },
        {
            "id": 5,
            "type": "Satire"
        },
        {
            "id": 6,
            "type": "Tragicomedy"
        },
        {
            "id": 7,
            "type": "Fantasy"
        }
    ]

}