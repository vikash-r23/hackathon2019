import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartUpsComponent } from './start-ups.component';

describe('StartUpsComponent', () => {
  let component: StartUpsComponent;
  let fixture: ComponentFixture<StartUpsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartUpsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartUpsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
