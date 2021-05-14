import { Component, OnInit } from '@angular/core';
import { SocialAuthService } from 'angularx-social-login';
import { SocialUser, GoogleLoginProvider } from 'angularx-social-login';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/userService/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user!: SocialUser;
  loggedIn!: boolean;
  constructor(
    private authService: SocialAuthService,
    private router:Router,
    private userService: UserService,
    ) { }

  ngOnInit(): void {

    this.authService.authState.subscribe((user) => {
      // this.user = user;
      // const email = this.user.email;
      // this.userService.getUserByEmail(email).subscribe(res=>{
      //   this.userService.setCurrentUser(res);
      //   console.log(res);
      // });   
      this.loggedIn = (user != null);
      if(this.loggedIn){
        this.userService.setCurrentUser(user);
        this.router.navigate(['/dashboard']);
      }else{
        this.router.navigate(['/login']);
      }
      }); 
  }

  signInGoogle(): void{
    this.authService.initState.subscribe(value => {
      this.authService.signIn(GoogleLoginProvider.PROVIDER_ID).then((user) => {
        console.log("User-Data", user);
        sessionStorage.setItem('userData',user.id);
        sessionStorage.setItem('name', user.name);
        sessionStorage.setItem('image', user.photoUrl);
        sessionStorage.setItem('idToken', user.idToken);
        // localStorage.setItem('idToken', user.idToken);
        // localStorage.setItem('email', user.email);

      });
    });
    
  }

//   signOut(): void{
//     sessionStorage.removeItem('userId');
//     sessionStorage.removeItem('email');
//     sessionStorage.removeItem('idToken');
//     this.authService.signOut();
//   }
}
