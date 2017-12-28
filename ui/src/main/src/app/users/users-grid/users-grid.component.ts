import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs/Observable";
import { DataSource } from '@angular/cdk/collections';


import { User } from "../user";
import { UsersService } from "../users.service";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-users-grid',
  templateUrl: './users-grid.component.html',
  styleUrls: ['./users-grid.component.css']
})
export class UsersGridComponent implements OnInit {

  dataSource: UserDataSource;
  displayedColumns = ['id', 'name', 'secondName', 'roles'];

  constructor(private usersService:UsersService) {
    this.dataSource = new UserDataSource(this.usersService);
  }

  ngOnInit() {
  }


}

export class UserDataSource extends DataSource<User> {

  constructor(private usersService:UsersService) {
    super();
  }

  connect(): Observable<User[]> {
    return this.usersService.getUsers();
  }

  disconnect() {}
}
