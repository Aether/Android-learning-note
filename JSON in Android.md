##### JSON:

    {
        "name":{
        
            "firstName":"John",
            "lastName":"Doe",
        }
        "title":"Missing Person"
    }

##### Initialize JSONObject from JSON string

    JSONObject contact = new JSONObject(contactJSONString);
    
##### Name into a JSONObect

    JSONObject name = contact.getJSONObject("name");
    
##### First an last names

    String firstName = name.getString("firstName");
    String lastName = name.getString("lastName");
    
##### Title

    String title = contact.getString("title");
    
