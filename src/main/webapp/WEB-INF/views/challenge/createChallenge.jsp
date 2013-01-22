<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>

<h3>Create a New Challenge</h3>

<form class="form-horizontal" action="/challenges/create" method="POST">
	<div class="control-group">
		<label class="control-label" for="challenge">Challenge</label>
		<div class="controls">
			<input type="text" name="challenge"
				placeholder="One line describing challenge" required="required"
				min="10" max="100">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="challengeDescription">Describe
			Challenge</label>
		<div class="controls">
			<textarea rows="5"
				placeholder="Describe Challenge in 4000 characters or less"
				maxlength="4000" name="challengeDescription" required="true"></textarea>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="startAt">Start At</label>
		<div id="datetimepicker" class="input-append date">
			<input type="datetime-local"
				placeholder="When should challenge Start" required="required"
				name="startAt"> <span class="add-on"> <i
				data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
			</span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" for="duration">Duration</label>
		<div class="controls">
		<select name="duration">
			<c:forEach var="dur" items="${duration}">
			
				<option value='<c:out value="${dur}"/>'></option>
			</c:forEach>
		</select>
		</div>
	</div>

	<button type="submit" class="btn">Create Challenge</button>
</form>

