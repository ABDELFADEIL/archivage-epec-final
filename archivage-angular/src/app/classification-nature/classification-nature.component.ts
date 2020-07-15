import { Component, OnInit } from '@angular/core';
import {ClassificationNature} from '../models/classification-nature';
import {ClassificationNatureService} from '../service/classification-nature.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-classification-nature',
  templateUrl: './classification-nature.component.html',
  styleUrls: ['./classification-nature.component.css']
})
export class ClassificationNatureComponent implements OnInit {
  classements: ClassificationNature [];
  public page : number = 1;
  public size : number= 12;
  public currentSize : number;
  currentPage : number = 1;
  public totalPages: number;
  public pages: number[];
  public filter;
  constructor(private  classificationNatureService: ClassificationNatureService, private router: Router) {
    this.getAllClassifcationNature();
  }
  public headerTitle:string="Classification Nature";

  ngOnInit(): void {

  }

  getAllClassifcationNaturePage(page){
    this.currentPage = page;
    this.classificationNatureService.getAll(this.currentPage).
    subscribe(value => {
      // this.totalPages=value["totalPages"];
      // this.pages= new Array<number>(this.totalPages);
      this.classements= value;
    }, error => {
      console.log(error);
    })
  }

  getAllClassifcationNature(){
    this.getAllClassifcationNaturePage(this.currentPage);
  }

  update(classificationNature: ClassificationNature) {
    this.classificationNatureService.update(classificationNature);
  }

  onDelete(id) {
    let conf = confirm("Êtes vous sûr de vouloir supprimer?");
    if(conf){
      this.classificationNatureService.delete(id).subscribe(value => {
        this.getAllClassifcationNature();
        this.router.navigateByUrl('/classifcation-nature');
      }, error => {
      });
    }

  }
}
