import {Directive, ViewContainerRef} from "@angular/core";

@Directive({
  selector: '[dt-host]',
})
export class DtDirective {
  constructor(public viewContainerRef: ViewContainerRef) { }
}
