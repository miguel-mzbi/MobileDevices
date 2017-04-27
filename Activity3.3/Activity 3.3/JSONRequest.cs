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

namespace Activity_3._3
{
    public class JSONRequest : AsyncTask<string, int, JavaList<Post>>
    {
        private JSONListener listener;

        public JSONRequest(JSONListener listener)
        {
            this.listener = listener;
        }

        protected override JavaList<Post> RunInBackground(params string[] @params)
        {
            JavaList<Post> result = null;

            try
            {
                HttpClient client = new HttpClient();
                HttpResponseMessage response = client.GetAsync(@params[0]).Result;

                if (response.IsSuccessStatusCode)
                {
                    string responseString = response.Content.ReadAsStringAsync().Result;
                    result = JsonConvert.DeserializeObject<JavaList<Post>>(responseString);
                }

            }
            catch (AggregateException ae)
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
            this.listener.Listen((JavaList<Post>) result);
            base.OnPostExecute(result);
        }

        public interface JSONListener
        {
            void Listen(JavaList<Post> posts);
        }
    }
}