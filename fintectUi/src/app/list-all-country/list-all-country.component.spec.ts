import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllCountryComponent } from './list-all-country.component';

describe('ListAllCountryComponent', () => {
  let component: ListAllCountryComponent;
  let fixture: ComponentFixture<ListAllCountryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAllCountryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAllCountryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
