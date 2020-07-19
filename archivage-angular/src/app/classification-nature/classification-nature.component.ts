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
  public keyword;

  constructor(private  classificationNatureService: ClassificationNatureService, private router: Router) {
    this.getAllClassifcationNature();
  }
  public headerTitle:string="Classification Nature";


  ngOnInit(): void {

  }

  getAllClassifcationNaturePage(){

    this.classificationNatureService.getAll().
    subscribe(value => {
      this.classements= value;
      console.log(this.classements);
    }, error => {
      console.log(error);
    })
  }

  getAllClassifcationNature(){
    this.getAllClassifcationNaturePage();
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
        console.log(error)
      });
    }

  }

  chercher(keyWord: any) {
    this.classificationNatureService.getByKeyWord(keyWord).subscribe(value => {
      this.classements= value;
      console.log(this.classements);
    }, error => {
      console.log(error);
    });
  }
}
