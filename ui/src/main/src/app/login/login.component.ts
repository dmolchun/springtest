import {Component, OnInit} from '@angular/core';
import {LoginService} from "./login.service";
import {UsersService} from "../users/users.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide = true;

  name: string;
  password: string;

  constructor(private loginService: LoginService, private userService: UsersService, private router: Router) {
  }

  ngOnInit() {
    this.redirectToMainIfIsAuth();
  }

  onLogin() {

    this.loginService.login(this.name, this.password).subscribe(
      next => {
        this.redirectToMainIfIsAuth();
      },
      error => {
        console.log("Error while login %s", error);
      });
  }

  redirectToMainIfIsAuth() {
    this.userService.getCurrentUser().subscribe(
      user => this.router.navigate(['/main']),
      error => console.log(error)
    )
  }
}
