let loadUsersBtn = document.getElementById('loadUsers')
loadUsersBtn.addEventListener('click', onLoadUsers)

function onLoadUsers (event) {
  const requestOptions = {
    method: 'GET',
    redirect: 'follow',
  }

  let usersContainer = document.getElementById('users-container')
  usersContainer.textContent = ''

  fetch('http://localhost:8080/api/users/', requestOptions).
    then(response => response.json()).
    then(json => json.forEach(user => {
      // here we will create some elements and add them to the table.
      let row = document.createElement('tr')

      let usernameCol = document.createElement('td')
      let levelCol = document.createElement('td')
      let roleCol = document.createElement('td')
      let actionCol = document.createElement('td')

      let profileLink = document.createElement('a')

      profileLink.setAttribute('href', `/users/profile/${user.id}`)
      profileLink.textContent = 'View Profile'
      profileLink.className = 'btn btn-primary'

      let roleArr = user.role.map(roleObj => roleObj['role'])

      usernameCol.textContent = user.username
      levelCol.textContent = user.level
      roleCol.textContent = roleArr
      actionCol.appendChild(profileLink)

      // add the columns to the parent row
      row.appendChild(usernameCol)
      row.appendChild(levelCol)
      row.appendChild(roleCol)
      row.appendChild(actionCol)

      usersContainer.appendChild(row)
    })).
    catch(error => console.log('error', error))
}

function notImplemented () {
  alert('This functionality require "Premium" account')

  function getFooter () {
    let footer = document.getElementById('footer')

    footer.textContent = "HEllo"

    console.log(footer)
  }
}