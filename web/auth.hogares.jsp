<%@page contentType="text/html" pageEncoding="UTF-8"%>

<md-table-container>
    <table md-table md-row-select multiple ng-model="selected" md-progress="promise">
        <thead md-head md-order="query.order" md-on-reorder="getDesserts">
            <tr md-row>
                <th md-column md-order-by="nameToLower"><span>Dessert (100g serving)</span></th>
                <th md-column md-numeric md-order-by="calories.value"><span>Calories</span></th>
                <th md-column md-numeric>Fat (g)</th>
                <th md-column md-numeric>Carbs (g)</th>
                <th md-column md-numeric>Protein (g)</th>
                <th md-column md-numeric>Sodium (mg)</th>
                <th md-column md-numeric>Calcium (%)</th>
                <th md-column md-numeric>Iron (%)</th>
            </tr>
        </thead>
        <tbody md-body>
            <tr md-row md-select="dessert" md-select-id="name" md-auto-select ng-repeat="dessert in desserts">
                <td md-cell>{{dessert.id}}</td>
                <td md-cell>{{dessert.calories.value}}</td>
                <td md-cell>{{dessert.fat.value| number: 1}}</td>
                <td md-cell>{{dessert.carbs.value}}</td>
                <td md-cell>{{dessert.protein.value| number: 1}}</td>
                <td md-cell>{{dessert.sodium.value}}</td>
                <td md-cell>{{dessert.calcium.value}}{{dessert.calcium.unit}}</td>
                <td md-cell>{{dessert.iron.value}}{{dessert.iron.unit}}</td>
            </tr>
        </tbody>
    </table>
</md-table-container>

