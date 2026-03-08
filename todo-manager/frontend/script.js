const API = "http://localhost:8080/tasks";

let editId = null;

async function loadTasks() {
  const response = await fetch(API);
  const data = await response.json();

  const tasks = data.content || data; // data for pagination or normal list

  let rows = "";

  tasks.forEach((t) => {
    rows += `
        <tr>
            <td>${t.id}</td>
            <td>${t.title}</td>
            <td>${t.description}</td>
            <td>${t.status}</td>

            <td>
            <button class="edit-btn" onclick="editTask(${t.id},'${t.title}','${t.description}','${t.status}')">Edit</button>

            <button class="delete-btn" onclick="deleteTask(${t.id})">Delete</button>
            </td>
        </tr>
        `;
  });

  document.getElementById("taskTable").innerHTML = rows;
}

async function saveTask() {
  const title = document.getElementById("title").value;
  const description = document.getElementById("description").value;
  const status = document.getElementById("status").value;

  if (editId == null) {
    await fetch(API, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ title, description, status }),
    });
  } else {
    await fetch(API + "/" + editId, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ title, description, status }),
    });

    editId = null;
    document.getElementById("saveBtn").innerText = "Add Task";
  }

  clearForm();
  loadTasks();
}

function editTask(id, title, description, status) {
  editId = id;

  document.getElementById("title").value=title;
  document.getElementById("description").value=description;
  document.getElementById("status").value=status;

  document.getElementById("saveBtn").innerText = "Update Task";
}

async function deleteTask(id) {
  await fetch(API + "/" + id, {
    method: "DELETE",
  });

  loadTasks();
}

function clearForm() {
  document.getElementById("title").value = "";
  document.getElementById("description").value = "";
  document.getElementById("status").value = "PENDING";

  editId = null;

  document.getElementById("saveBtn").innerText = "Add Task";
}

loadTasks();
