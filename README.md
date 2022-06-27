<h1>Lock Picking App</h1>

This is an application made to store lock picks, tension tools, bypass tools and locks. It also goes into detail on how each tool works, and what tools can be used to open each lock.

<img src="https://user-images.githubusercontent.com/85071007/174098067-b25ea2e5-380f-4a73-ba6b-d9f78b5fc636.JPG" style="height:250px;" />

<h1>Built with</h1>

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

<h1>User roles</h1>

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
<h1>Deployment</h1>
<ul>
  <li>Deployed through <a href="https://lockpickingapp.herokuapp.com/">Heroku</a></li>
  <li>Uses ClearDB as a database</li>
  <li>User requests send as emails via FormSubmit</li>
</ul>

<h1>Future updates</h1>
<ol>
  <li>User detail pages</li>
  <li>Direct file upload as opposed to linking to images</li>
  <li>Share buttons allowing users to send locks and tools easily</li>
  <li>Sorting by brand name once more locks are in the database</li>
  <li>Smithing pages, going into further detail about the internal mechanisms of each lock</li>
</ol>