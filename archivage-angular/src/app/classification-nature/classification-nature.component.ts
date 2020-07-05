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
  classements: ClassificationNature;

  constructor(private  classificationNatureService: ClassificationNatureService, private router: Router) { }

  ngOnInit(): void {
    this.getAllClassifcationNature();
  }

  getAllClassifcationNature(){
    this.classificationNatureService.getAll().subscribe(value => {
      console.log(value);
      this.classements= value;
    }, error => {
      console.log(error);
    })
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
