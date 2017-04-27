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
using Android.Util;
using System.Net.Http;
using Newtonsoft.Json;

namespace XamarinClaseMartes
{
    class JSONRequest : AsyncTask<string, int, List<Post>>
    {
        private JSONListener listener;

        protected override List<Post> RunInBackground(params string[] @params)
        {
            List<Post> result = null;
            
            try
            {
                HttpClient client = new HttpClient();
                HttpResponseMessage response = client.GetAsync(@params[0]).Result;

                if (response.IsSuccessStatusCode)
                {
                    string responseString = response.Content.ReadAsStringAsync().Result;
                    result = JsonConvert.DeserializeObject<List<Post>>(responseString);
                }

                Log.Debug("PRIMERO", result[0].title);

            }
            catch(AggregateException ae)
            {
                foreach (var e in ae.Flatten().InnerExceptions)
                {
                    Log.Error("EXCEPTION", e.Message);
                }
            }

            return result;
        }

        protected override void OnPostExecute(Java.Lang.Object result)
        {
            base.OnPostExecute(result);
        }

        public interface JSONListener
        {
            void Listen(List<Post> posts);
        }
    }
}