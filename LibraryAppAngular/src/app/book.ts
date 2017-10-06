import { Genre } from './genre';
import { Author } from './author';

export class Book {
  constructor(
    public id: number,
    public isbnNumber: string,
    public title: string,
    public author: Author,
    public genres: Genre[],
    public pageCount: number,
    public publishDate: string,
    public borrower?: string
  ) {  }
    
}