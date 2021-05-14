import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SocialAuthService } from 'angularx-social-login';

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css']
})
export class NavigationBarComponent implements OnInit {

  userName!: string;
  constructor(
    private authService: SocialAuthService,
    private router: Router, 
    ) { }

  ngOnInit(): void {
    this.userName = sessionStorage.getItem('name')!;
  }

  dashboard(){
    this.router.navigate(['/dashboard']);
  }

  creator(){
    this.router.navigate(['/courses']);
  }

  trainer(){
    this.router.navigate(['/trainings']);
  }

  student(){
    this.router.navigate(['/students']);
  }

  getImg(){
    return 'url(' + sessionStorage.getItem('image') + ')';
  }

  logout() {
    if(confirm("Confirm logout?")){
      sessionStorage.clear();
      this.authService.signOut().then(data => {
        this.router.navigate(['/login']);
      }).catch(err =>
        {
          console.log(err);
          this.router.navigate(['/login']);
        });
    }
  }
}
