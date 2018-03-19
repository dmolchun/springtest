import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs/Observable";
import {DataSource, SelectionModel} from '@angular/cdk/collections';


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
  displayedColumns = ['select', 'id', 'name', 'secondName', 'roles'];

  selection = new SelectionModel<User>(true, []);

  constructor(private usersService:UsersService) {
    this.dataSource = new UserDataSource(this.usersService);
  }

  ngOnInit() {
  }

  getSelected(): User[] {
    return this.selection.selected;
  }

  refresh() {
    this.dataSource = new UserDataSource(this.usersService);
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
