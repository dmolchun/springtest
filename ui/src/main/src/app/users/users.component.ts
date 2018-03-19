import {Component, ComponentFactoryResolver, OnInit, ViewChild} from '@angular/core';
import {UserCardComponent} from "./user-card/user-card.component";
import {DtDirective} from "./dt.directive";
import {UsersGridComponent} from "./users-grid/users-grid.component";

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

  constructor(private componentFactoryResolver: ComponentFactoryResolver) {
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
    return this.userGrid.getSelected().length != 1;
  }

  editUser() {
    let component = this.createNew();
    component.id = this.userGrid.getSelected()[0].id;
  }

  refreshGrid() {
    this.userGrid.refresh();
  }


}
