import {Component, Input, OnInit} from '@angular/core';
import {Account} from '../models/account';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {AccountService} from '../service/account.service';
import {Router} from '@angular/router';
import {Contract} from '../models/contract';
import {ContractService} from '../service/contract.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-update-contract',
  templateUrl: './update-contract.component.html',
  styleUrls: ['./update-contract.component.css']
})
export class UpdateContractComponent implements OnInit {
  public files: File [] = [];
  public status;


  @Input()  contract: Contract;

  constructor(public activeModal: NgbActiveModal, private contractService: ContractService, private router : Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.contract);
    this.contract.status = this.status;
    console.log(this.status)
    this.contractService.update(this.contract).subscribe(data => {
      this.closeModal();
      this.router.navigateByUrl('contracts')
    }, error => {

    })
  }

  closeModal() {
    this.activeModal.close();
  }

  uploadFile(event) {
    for (let index = 0; index < event.length; index++) {
      const element = event[index];
      this.files.push(element)
    }
    console.log(this.files);
  }



  docs: boolean = false;



  deleteAttachment(index) {
    this.files.splice(index, 1);
  }
}


