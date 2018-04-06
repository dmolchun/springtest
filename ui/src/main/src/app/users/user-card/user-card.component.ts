import {Component, OnInit} from '@angular/core';
import {User} from "../user";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material";
import {UsersService} from "../users.service";

/**
 * Component to show user info
 */
@Component({
  selector: 'app-user-card',
  templateUrl: './user-card.component.html',
  styleUrls: ['./user-card.component.css']
})
export class UserCardComponent implements OnInit {
  private _active = true;
  private _isEditMode = false;
  private _label = "User's card";
  private _user = new User();
  private _userRoles: string[];
  private _userLoginControl = new FormControl('', [Validators.required]);
  private _userNameControl = new FormControl('', [Validators.required]);
  private _userRolesControl = new FormControl('', [Validators.required]);
  private _userControls;

  constructor(private _usersService: UsersService, private _snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this._userControls = new FormGroup({
      login: this._userLoginControl,
      name: this._userNameControl,
      roles: this._userRolesControl
    });
    this._usersService.getRoles().subscribe(
      res => {
        this._userRoles = res;
      }
    );
  }

  getUserInfo(id: number) {
    this._usersService.getUser(id).subscribe(
      user => {
        this._user = user;
      },
      error => {
        console.error(error);
        this._snackBar.open("Error getting user info. Try again.", "", {
          duration: 2000,
        });
      }
    );

  }

  save() {
    if (this._userControls.valid) {
      this._usersService.saveUser(this._user).subscribe(
        res => {
          this._user = res;
          this._snackBar.open("Successfully saved", "", {
            duration: 2000,
          });
        },
        e => {
          console.log(e);
          this._snackBar.open(e.error, "", {
            duration: 2000,
          });
        }
      );
    } else {
      this._snackBar.open("Check fields", "", {
        duration: 2000,
      });
    }
  }

  edit() {
    this._isEditMode = true;
  }

  isNew() {
    return !this._user || !this._user.id;
  }

  set active(value: boolean) {
    this._active = value;
  }

  get label(): string {
    return this._label;
  }

  set id(value: number) {
    if (!this._user.id) {
      this._user.id = value;
      this.getUserInfo(value);
    }
  }

}
