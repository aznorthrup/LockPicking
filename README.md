<h1>Lock Picking App</h1>

This is an application made to store lock picks, tension tools, bypass tools and locks. It also goes into detail on how each tool works, and what tools can be used to open each lock.

<img src="https://user-images.githubusercontent.com/85071007/174098067-b25ea2e5-380f-4a73-ba6b-d9f78b5fc636.JPG" style="width:300px;" />

<h1>Built With</h1>

<ul>
  <li>Java</li>
  <li>HTML</li>
  <li>CSS</li>
  <li>JavaScript</li>
  <li>jQuery</li>
  <li>BootStrap</li>
  <li>Spring Boot</li>
  <li>Spring Security</li>
  <li>MySQL</li>
  <li>jUnit</li>
</ul>

<h1>Deployment</h1>
<ul>
  <li>Deployed through <a href="https://lockpickingapp.herokuapp.com/">Heroku</a></li>
  <li>Uses ClearDB as a database</li>
  <li>User requests send as emails via FormSubmit</li>
</ul>

<h1>User Roles Overview</h1>

<ol>
	<li>
		Unauthenticated Users
		<ul>
			<li>
				Can view the list and detail pages for locks, picks, tension tools, and bypass tools
			</li>
		</ul>
	</li>
	<li>
		Authenticated Users
		<ul>
			<li>
				Can also view the list and detail pages for locks, picks, tension tools, and bypass tools
			</li>
			<li>
				Have a modal on the home page allowing them to submit requests
			</li>
		</ul>
	</li>
	<li>
		Administrators
		<ul>
			<li>
				Can view all pages visible to unauthenticated and authenticated users
			</li>
			<li>
				Can view the add, update, and delete <u>buttons</u> as well as the add and update <u>pages</u> for locks, picks, tension tools, and bypass tools
			</li>
			<li>
				Can follow through with the associated requests of the aforementioned buttons and pages
			</li>
		</ul>
	</li>
</ol>

<h1>Role Examples</h1>

<h3>Unauthenticated(first image) vs Authenticated(second image)</h3>

<h6>When viewing the home page</h6>
<img src="https://user-images.githubusercontent.com/85071007/176010518-76e93b94-1785-42c5-8e0d-bd1b2515e2d7.JPG" style="width: 550px;margin:5px;" />
<img src="https://user-images.githubusercontent.com/85071007/176010593-316ff810-bc19-4b09-98d9-309ab6172a83.JPG" style="width: 550px;margin:5px;" />


<br>

<h6>Welcome message</h6>
<img src="https://user-images.githubusercontent.com/85071007/176010758-269ea12c-4d85-412f-86a8-095ed2524a58.JPG" style="width: 550px;margin:5px;" />
<img src="https://user-images.githubusercontent.com/85071007/176010746-32a76c89-03f2-45bf-bbd4-c5dd41cf1929.JPG" style="width: 550px;margin:5px;" />


<h3>Users(first image) vs Administrators(second image)</h3>

<h6>When viewing the list of locks</h6>
<img src="https://user-images.githubusercontent.com/85071007/176010773-d6ae22e6-af65-42ff-9657-61440be7fad7.JPG" style="width: 550px;margin:5px;" />
<img src="https://user-images.githubusercontent.com/85071007/176010782-c5cf0728-3236-4894-82f0-08505f943de5.JPG" style="width: 550px;margin:5px;" />


<br>

<h6>When viewing a particular lock</h6>
<img src="https://user-images.githubusercontent.com/85071007/176011078-1b4af842-0267-478b-9d02-3261cbb6dfe3.JPG" style="width: 550px;margin:5px;" />
<img src="https://user-images.githubusercontent.com/85071007/176011099-70fbd24a-1767-4162-a5dc-8f67438b79dc.JPG" style="width: 550px;margin:5px;" />


<br>

<h6>When navigating to "/add..." from the url</h6>
<img src="https://user-images.githubusercontent.com/85071007/176011376-9f8a0d1e-7310-4d84-885c-503ec0ca2b24.JPG" style="width: 550px;margin:5px;" />
<img src="https://user-images.githubusercontent.com/85071007/176011314-3c980bc3-88c5-49a9-9ea2-89f1329ec164.JPG" style="width: 550px;margin:5px;" />


<h1>Future Updates</h1>
<ol>
  <li>User detail pages</li>
  <li>Direct file upload as opposed to linking to images</li>
  <li>Share buttons allowing users to send locks and tools easily</li>
  <li>Sorting by brand name once more locks are in the database</li>
  <li>Smithing pages, going into further detail about the internal mechanisms of each lock</li>
</ol>
