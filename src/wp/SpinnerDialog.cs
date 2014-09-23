using System;
using System.Windows;
using System.Windows.Controls;
using Microsoft.Devices;
using System.Runtime.Serialization;
using Microsoft.Phone.Controls;
using WPCordovaClassLib.Cordova;
using WPCordovaClassLib.Cordova.Commands;
using WPCordovaClassLib.Cordova.JSON;

namespace WPCordovaClassLib.Cordova.Commands
{
    public class SpinnerDialog : BaseCommand
    {

        private static ProgressIndicator progressIndicator;
        private static PhoneApplicationPage currentPage;

        public void show(string options)
        {

            string[] args = JSON.JsonHelper.Deserialize<string[]>(options);
            string title = args[0];
            string message = args[1];

            if (message == null)
            {
                message = title;
            }

            if (progressIndicator == null)
            {
                progressIndicator = new ProgressIndicator() { IsIndeterminate = true };
            }
            progressIndicator.Text = message;
            progressIndicator.IsVisible = true;

            if (currenPage == null)
            {
                currentPage = (Application.Current.RootVisual as PhoneApplicationFrame).Content as PhoneApplicationPage;
            }

            SystemTray.SetProgressIndicator(currentPage, progressIndicator);

        }

        public void hide()
        {

            if (progressIndicator != null && currentPage != null)
            {
                progressIndicator.IsVisible = false;
                SystemTray.SetProgressIndicator(currentPage, progressIndicator);
            }

        }

    }
}