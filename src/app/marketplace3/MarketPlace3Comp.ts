import { Component } from '@angular/core';

@Component({
  selector: 'MarketPlace3Comp',
  templateUrl: './MarketPlace3Comp.html',
  styleUrls: ['./MarketPlace3Comp.scss']
})
export class MarketPlace3Comp {
  title: string;

  constructor() {
    this.title = 'Hello, Angular!';
  }
}