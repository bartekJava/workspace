angular.module('hellogalaxy').component('hello',{
    template: '<h3>{{$ctrl.greeting}} Solar System!</h3>' + '<button ng-click="$ctrl.toggleGreeting()">toggle greeting</button>',
    controller: function() {
        this.greeting = 'hello';

        this.toggleGreeting = function() {
            this.greeting = (this.greeting == 'hello') ? 'whats up' : 'hello'
        }
    }

});

var helloGalaxy = {
  name: 'hello',
  url: '/hello',
  component: 'hello'
};

var peopleState = {
  name: 'people',
  url: '/people',
  component: 'people',
  resolve: {
    people: function(PeopleService) {
      return PeopleService.getAllPeople();
    }
  }
};



