import { Book } from './book';
import { Borrower } from './borrower';

export class Borrow {
    constructor(
        public id: number,
        public borrower: Borrower,
        public book: Book
    ) { }

}