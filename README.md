# Practical-7: Fetch JSON Data from Internet API and Store in SQLite

## Aim

To develop an Android application that retrieves **person/contact data in JSON format from an Internet API** and stores the retrieved data in an **SQLite database**.

## Tools Required

* Android Studio
* Android SDK
* Kotlin
* Internet connection
* Android Emulator or Android device
* JSON Generator
* SQLite Database

## Practical Objectives

### 7.1 Create JSON Data for Contacts

Create JSON data for contact information using an online JSON generator.

The contact data contains fields such as:

* ID
* First Name
* Last Name
* Phone Number
* Email ID
* Address
* Latitude
* Longitude

The JSON data can be generated using:

**JSON Generator:**
https://app.json-generator.com/

The generated URL is then used by the Android application to retrieve the JSON data.

---

## 7.2 Create MainActivity

Create `MainActivity` according to the given UI design.

The MainActivity is responsible for:

* Fetching person data from the Internet
* Processing the retrieved JSON data
* Storing the data in SQLite
* Displaying the person information

The retrieved records can be displayed using either a `RecyclerView` or a `ListView`.

---

## 7.3 Person Class

Create a `Person` class containing the required member variables.

The class should contain:

```text
id
name
emailId
phoneNo
address
latitude
longitude
```

The `name` field can represent the person's first name and last name.

The class is made serializable so that Person objects can be passed between Android components when required.

Example structure:

```kotlin id="p7m1ca"
class Person(
    var id: String,
    var name: String,
    var emailId: String,
    var phoneNo: String,
    var address: String,
    var latitude: Double,
    var longitude: Double
) : Serializable
```

---

## 7.4 JSON Format

JSON stands for **JavaScript Object Notation**.

It is a lightweight data format commonly used for transferring structured data between a server and an application.

A person record can be represented conceptually as:

```json id="k5d7hx"
{
    "id": "1",
    "name": {
        "first": "John",
        "last": "Doe"
    },
    "phoneNo": "9876543210",
    "emailId": "john@example.com",
    "address": "Ahmedabad",
    "latitude": 23.0225,
    "longitude": 72.5714
}
```

Multiple person records can be represented using a JSON array.

---

## 7.5 RecyclerView or ListView

Use a `RecyclerView` or `ListView` to display the retrieved person data.

### RecyclerView

`RecyclerView` is an Android UI component used to efficiently display a large collection of data.

The application can create:

* RecyclerView
* Adapter
* ViewHolder
* Person data list

Example flow:

```text id="q7w4y8"
JSON Data
    ↓
Person Objects
    ↓
RecyclerView Adapter
    ↓
RecyclerView
    ↓
Person Information
```

### ListView

Alternatively, `ListView` can be used to display the list of persons.

---

## 7.6 Internet Permission

Internet permission must be added to the `AndroidManifest.xml` file so that the application can communicate with the web API.

```xml id="6t8q3f"
<uses-permission android:name="android.permission.INTERNET" />
```

This permission allows the application to access Internet resources.

---

## 7.7 HttpRequest Class

Create a separate `HttpRequest` class for communicating with the generated JSON web URL.

The class is responsible for:

1. Opening a connection to the URL.
2. Sending the HTTP request.
3. Receiving the response.
4. Reading the JSON data.
5. Returning the retrieved data to the application.

The practical specifies the use of `HttpURLConnection` for communication with the web URL.

Basic flow:

```text id="0g4n9z"
JSON URL
   ↓
HttpRequest
   ↓
HttpURLConnection
   ↓
Internet API
   ↓
JSON Response
   ↓
Application
```

---

## 7.8 HttpURLConnection

`HttpURLConnection` can be used to establish an HTTP connection with the web server.

The general process is:

```text id="t9v3sm"
Create URL
     ↓
Open Connection
     ↓
Connect to Server
     ↓
Read Response
     ↓
Convert Response to String
     ↓
Process JSON
```

The retrieved response can then be parsed into Person objects.

---

## 7.9 CoroutineScope

`CoroutineScope` is used with Kotlin Coroutines to perform network-related work without blocking the main UI thread.

Network communication should be performed away from the main UI thread.

Conceptually:

```text id="u8f4yn"
Main Thread
    |
    |---- Start Coroutine
             |
             ↓
       Network Request
             |
             ↓
         JSON Data
             |
             ↓
       Process Data
             |
             ↓
       Update UI
```

This helps keep the application responsive while data is being retrieved from the Internet.

---

## 7.10 Store Data in SQLite Database

After retrieving the JSON data, the application stores the person records in an SQLite database.

The basic process is:

```text id="p3r9wx"
Internet API
     ↓
JSON Response
     ↓
JSON Parsing
     ↓
Person Objects
     ↓
SQLite Database
     ↓
RecyclerView / ListView
```

The database can contain columns corresponding to the Person class:

| Field       | Description          |
| ----------- | -------------------- |
| `id`        | Unique person ID     |
| `name`      | Person's name        |
| `emailId`   | Email address        |
| `phoneNo`   | Phone number         |
| `address`   | Address              |
| `latitude`  | Geographic latitude  |
| `longitude` | Geographic longitude |

---

## Application Flow

```text id="6s1x8v"
        Start Application
               |
               ↓
          MainActivity
               |
               ↓
        HttpRequest Class
               |
               ↓
        HttpURLConnection
               |
               ↓
          JSON Web URL
               |
               ↓
          JSON Response
               |
               ↓
        Parse JSON Data
               |
               ↓
         Person Objects
               |
               ↓
        SQLite Database
               |
               ↓
       RecyclerView/ListView
               |
               ↓
       Display Person Data
```

## Important Components

| Component           | Purpose                                |
| ------------------- | -------------------------------------- |
| JSON                | Represents structured person data      |
| JSON Generator      | Generates sample JSON data             |
| MainActivity        | Controls the main application screen   |
| Person              | Represents person/contact information  |
| HttpRequest         | Handles communication with the web URL |
| HttpURLConnection   | Establishes HTTP connection            |
| CoroutineScope      | Performs asynchronous operations       |
| SQLite              | Stores retrieved person data locally   |
| RecyclerView        | Displays person records                |
| ListView            | Alternative list display component     |
| Internet Permission | Allows Internet access                 |

## Expected Learning Outcomes

After completing this practical, the student will be able to:

1. Understand the JSON data format.
2. Generate sample JSON data using a JSON generator.
3. Create a model class for person/contact data.
4. Understand `Serializable`.
5. Retrieve data from an Internet API.
6. Use `HttpURLConnection` for HTTP communication.
7. Create a separate `HttpRequest` class.
8. Use Kotlin `CoroutineScope` for asynchronous operations.
9. Parse JSON data into application objects.
10. Store retrieved information in an SQLite database.
11. Display data using `RecyclerView`.
12. Understand the use of `ListView` as an alternative.
13. Add Internet permission in the Android Manifest.
14. Understand the flow of data from an Internet API to a local SQLite database.

## Conclusion

This practical demonstrates how an Android application can retrieve **person/contact information in JSON format from an Internet API**, process the received data, store it in an **SQLite database**, and display the information using a `RecyclerView` or `ListView`.

The practical provides hands-on experience with **JSON, HttpURLConnection, CoroutineScope, SQLite, RecyclerView/ListView, Internet permissions, and Android data handling**.
