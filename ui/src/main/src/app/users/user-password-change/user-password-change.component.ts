import {Component, Inject, OnInit} from '@angular/core';
import {MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-user-password-change',
  templateUrl: './user-password-change.component.html',
  styleUrls: ['./user-password-change.component.css']
})
export class UserPasswordChangeComponent implements OnInit {

  passNew: string;
  passConfirm: string;

  constructor(public dialogRef: MatDialogRef<UserPasswordChangeComponent>) { }

  ngOnInit() {
  }

  onCancel() {
    this.dialogRef.close();
  }

  enableOkButton(): boolean {
    return this.passNew && this.passNew.length > 0 && this.passNew === this.passConfirm;
  }

}
