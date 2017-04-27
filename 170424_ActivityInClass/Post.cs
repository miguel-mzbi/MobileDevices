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

namespace XamarinClaseMartes
{
    // int userId, int id, string title, string body
    class Post
    {
        public int userID { get; set; }
        public int id { get; set; }
        public string title { get; set; }
        public string body { get; set; }
    }
}