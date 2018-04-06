import {Component, ComponentFactoryResolver, OnInit, ViewChild} from '@angular/core';
import {UserCardComponent} from "./user-card/user-card.component";
import {DtDirective} from "./dt.directive";
import {UsersGridComponent} from "./users-grid/users-grid.component";
import {UsersService} from "./users.service";
import {MatDialog, MatSnackBar} from "@angular/material";
import {UserPasswordChangeComponent} from "./user-password-change/user-password-change.component";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  tabs: UserCardComponent[] = [];

  selectedIndex = 0;

  @ViewChild('userCard') userCard;
  @ViewChild(DtDirective) dtHost: DtDirective;
  @ViewChild(UsersGridComponent) userGrid: UsersGridComponent;

  constructor(private componentFactoryResolver: ComponentFactoryResolver,
              private usersService: UsersService,
              private dialog: MatDialog,
              private _snackBar: MatSnackBar) {
  }

  ngOnInit() {
  }

  /**
   * Creating new user card component and related tab
   */
  createNew(): UserCardComponent {
    let componentFactory = this.componentFactoryResolver.resolveComponentFactory(UserCardComponent);
    let componentRef = this.dtHost.viewContainerRef.createComponent(componentFactory);
    this.tabs.push(
      componentRef.instance as UserCardComponent
    );
    componentRef.instance.active = false;
    this.selectedIndex = this.tabs.length;
    return componentRef.instance;
  }

  /**
   * Closing tab
   */
  closeTab(tab: UserCardComponent) {
    for (let i = 0; i < this.tabs.length; i++) {
      if (this.tabs[i] === tab) {
        // remove the tab from our array
        this.tabs.splice(i, 1);

        // destroy our dynamically created component again
        let viewContainerRef = this.dtHost.viewContainerRef;
        // let viewContainerRef = this.dynamicTabPlaceholder;
        viewContainerRef.remove(i);

        // set tab index to 1st one
        this.selectedIndex = 0;
        break;
      }
    }
  }

  /**
   * Event fires when active tab changes
   * @param event
   */
  tabChanged(event) {
    for (let tab of this.tabs) {
      tab.active = false;
    }
    let currentTab = this.tabs[event.index - 1];
    if (currentTab) {
      currentTab.active = true;
    }
  }

  disableEditButton(): boolean {
    let currentUser = this.usersService.getCurrentUser();
    return this.userGrid.getSelected().length != 1 && currentUser && currentUser.roles.indexOf('ADMIN') > -1;
  }

  editUser() {
    let component = this.createNew();
    component.id = this.userGrid.getSelected()[0].id;
  }

  deleteUser() {
    this.usersService.deleteUser(this.userGrid.getSelected()[0].id).subscribe(
      next => {
        this.refreshGrid();
        this._snackBar.open("User successfully deleted", "", {
          duration: 2000,
        })
      },
      err => {
        console.log(err);
        this._snackBar.open("Error while deleting user", "", {
          duration: 2000,
        });
      }
    );

  }

  changePassword() {
    let dialogRef = this.dialog.open(UserPasswordChangeComponent, {
      width: '250px'
    });

    dialogRef.afterClosed().subscribe(result => {
        if (result) {
          let user = this.userGrid.getSelected()[0];
          user.password = result;
          this.usersService.changePassword(user).subscribe(
            result => {
              this._snackBar.open("Password successfully changed", "", {
                duration: 2000,
              })
            },
            err => {
              console.log(err);
              this._snackBar.open("Error while changing password", "", {
                duration: 2000,
              });
            }
          );
        }
      }
    )
    ;
  }

  refreshGrid() {
    this.userGrid.refresh();
  }


}
