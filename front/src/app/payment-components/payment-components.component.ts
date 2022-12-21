import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-payment-components',
  templateUrl: './payment-components.component.html',
  styleUrls: ['./payment-components.component.scss']
})
export class PaymentComponentsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    const stripe = Stripe('pk_test_51MEYdlITh9f7lOi1UOyqYf2x2osrko6JHcrMVk9BYLPOiJN9kDqTTjDNpIQ4XWHoz9srVKClNHf5a3BqajdR63EE003PWmhBbw');
    var elements = stripe.elements();

    var card = elements.create('card', {
      style: {
        base: {
          iconColor: '#c4f0ff',
          color: '#fff',
          fontWeight: '500',
          fontFamily: 'Roboto, Open Sans, Segoe UI, sans-serif',
          fontSize: '16px',
          fontSmoothing: 'antialiased',
          ':-webkit-autofill': {
            color: '#fce883',
          },
          '::placeholder': {
            color: '#87BBFD',
          },
        },
        invalid: {
          iconColor: '#FFC7EE',
          color: '#FFC7EE',
        },
      },
    });

    // Add an instance of the card UI component into the `card-element` <div>
    card.mount('#card-element');

    // Remove Zip-code in card UI component
    //var card = elements.create('card', { hidePostalCode: true, style: styleCard });

    card.addEventListener('change', function(event) {
      var displayError = document.getElementById('card-errors');
      
    });

  }

  

}
