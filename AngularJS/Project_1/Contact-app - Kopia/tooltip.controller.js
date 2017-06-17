(function () {
    var app = angular.module("ContactApp");

    app.controller('TooltipDemoCtrl', function ($scope, $sce) {
        var self = this;
        self.dynamicTooltip = 'Hello, World!';
        self.dynamicTooltipText = 'dynamic';
        self.htmlTooltip = $sce.trustAsHtml('I\'ve been made <b>bold</b>!');
        self.placement = {
            options: [
                'top',
                'top-left',
                'top-right',
                'bottom',
                'bottom-left',
                'bottom-right',
                'left',
                'left-top',
                'left-bottom',
                'right',
                'right-top',
                'right-bottom'
            ],
            selected: 'top'
        };
    });
})();