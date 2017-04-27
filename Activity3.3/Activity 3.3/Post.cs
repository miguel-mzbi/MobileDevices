using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace Activity_3._3
{
    public class Post : Java.Lang.Object
    {
        public int userID { get; set; }
        public int id { get; set; }
        public string title { get; set; }
        public string body { get; set; }
    }
}