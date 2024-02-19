import { Routes } from '@angular/router';
import { Vegetable2Comp } from './vegetable2/Vegetable2Comp';
import { MarketPlace3Comp } from './marketplace3/MarketPlace3Comp';


export const routes: Routes = [{
  path: 'vegetable2',
  component: Vegetable2Comp,

},
{
  path: 'marketplace3',
  component: MarketPlace3Comp,
}
]