import { Component } from '@angular/core';

@Component({
  selector: 'Vegetable2Comp',
  templateUrl: './Vegetable2Comp.html',
  styleUrls: ['./Vegetable2Comp.scss']
})
export class Vegetable2Comp {
  title: string;

  constructor() {
    this.title = 'Hello, Angular!';
  }
}