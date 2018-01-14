Constants:

    final static String GITHUB_BASE_URL =
            "https://api.github.com/search/repositories";
    final static String PARAM_QUERY = "q";
    final static String PARAM_SORT = "sort";
    final static String sortBy = "stars";

To build our search URL,we can take advantage of the Android URI.builder framework class. It allows us to create a well-formed URI,without having to worry about the particulars of URI components.

For example, adding & between query parameters and encoding invalid characters with a percent followed by the character code.

URL is a specific class of Uri.Once we’ve created our base URI by parsing the GITHUB_BASE_URL string we created a Uri.builder using the buildUpon method.Then we can call appendQuery parameter for our search query and sort fields.Finally we call build to produce the Uri we’ll use to query GITHUB.

However,this produces an **Android Uri** while our method requires a **Java URL**.We can convert our new built Uri to a Java URL by passing it as a string parameter to the Java URL constructor.

    public static URL buildUrl(String githubSearchQuery) {
        Uri builtUri = Uri.parse(GITHUB_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY,githubSearchQuery)
                .appendQueryParameter(PARAM_SORT,sortBy)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }

Then make a method called makeGithubSearchQuery. It pulls the githubQuery from the edit text,calls the buildUrl method we just wrote, and displays the resulting URL in the Url DisplayTextView.

Finally,we call to the makeGithubSearchQuery method from onOptionItemSelected.Now when we hit the search button in the action bar,we'll display the URL that we're going to query.

    private void makeGithubSeachQuery(){
        String githubQuery = mSearchBoxEditText.getText().toString();
        URL githubSearchUrl = NetworkUtils.buildUrl(githubQuery);
        mUrlDisplayTextView.setText(githubSearchUrl.toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            makeGithubSeachQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }