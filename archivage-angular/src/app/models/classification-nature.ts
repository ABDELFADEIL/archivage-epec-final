import {Injectable} from '@angular/core';


@Injectable({
  providedIn: 'root',
})

export class ClassificationNature {

   classification_nature_id : number;
   classification_nature_label : string;
   classification_nature_code : number;
   duration : number;

    constructor() {
    }
}
