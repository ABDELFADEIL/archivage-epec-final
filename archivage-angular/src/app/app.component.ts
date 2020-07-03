import {Component, ElementRef, HostListener, Renderer2, ViewChild} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {filter, map, mergeMap} from 'rxjs/operators';
import {Title} from "@angular/platform-browser";
import {User} from './models/user';
import {AuthenticationService} from './service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {


 // @ViewChild('menu') menu: ElementRef;

  ngOnInit(): void {
    if (this.authService.jwtToken == null){
      this.router.navigateByUrl('/login');
    }
  }


  constructor(private router: Router, private activatedRoute: ActivatedRoute, public authService:AuthenticationService,
              private renderer: Renderer2, private titleService: Title, private _eref: ElementRef) {}




}
