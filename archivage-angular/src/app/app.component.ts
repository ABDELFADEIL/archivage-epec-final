import { Component } from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {filter, map, mergeMap} from 'rxjs/operators';
import {Title} from "@angular/platform-browser";
import {AppService} from './appService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title ;
  // titleAfiche:string;
 supTitle: string;

  constructor(private router: Router, private activatedRoute: ActivatedRoute, private titleService: Title, public appService:AppService) {
    const appTitle = this.titleService.getTitle();
    this.router
      .events.pipe(
      filter(event => event instanceof NavigationEnd),
      map(() => {
       // this.supTitle = this.activatedRoute;
        const child = this.activatedRoute.firstChild;
        if (child.snapshot.data['title']) {
          return child.snapshot.data['title'];
        }
        return appTitle;
      })

    ).subscribe(ttl => {
      console.log("appTitle "+ttl)
      console.log(this.activatedRoute)
      this.titleService.setTitle(ttl);
      this.title = this.titleService.getTitle();

    });
  }
  ngOnInit(){

  }


}
