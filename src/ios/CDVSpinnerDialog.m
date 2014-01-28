//
//  CDVSpinnerDialog.m
//  HelloWorld
//
//  Created by Domonkos Pál on 2014.01.27..
//
//

#import "CDVSpinnerDialog.h"

@interface CDVSpinnerDialog () {
    UIActivityIndicatorView *indicator;
}
    
@property (nonatomic, retain) UIActivityIndicatorView *indicator;
@property (nonatomic, retain) UIView *overlay;

@end

@implementation CDVSpinnerDialog
    
@synthesize indicator = _indicator;
@synthesize overlay = _overlay;

    
-(UIView *)overlay {
    if (!_overlay) {
        _overlay = [[UIView alloc] initWithFrame:[UIScreen mainScreen].bounds];
        _overlay.backgroundColor = [UIColor colorWithRed:0 green:0 blue:0 alpha:0.25];
        _indicator = [[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleWhiteLarge];
        _indicator.center = _overlay.center;
        [_indicator startAnimating];
        [_overlay addSubview:_indicator];
    }
    return _overlay;
}

    
- (void) show:(CDVInvokedUrlCommand*)command {
    
    
    UIViewController *rootViewController = [[[[UIApplication sharedApplication] delegate] window] rootViewController];
    
    [rootViewController.view addSubview:self.overlay];

    
}
    
    
- (void) hide:(CDVInvokedUrlCommand*)command {
    if (_overlay) {
        [self.indicator stopAnimating];
        [self.indicator removeFromSuperview];
        [self.overlay removeFromSuperview];
        _indicator = nil;
        _overlay = nil;
    }
}
    
#pragma mark - PRIVATE METHODS
 
    
@end




