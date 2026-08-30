# Actividad Corte 1 - Clase Encapsulada en Java

## Descripción

Este proyecto implementa una clase `CuentaBancaria` aplicando conceptos fundamentales de Programación Orientada a Objetos, especialmente encapsulamiento, validación de datos y redefinición de métodos de la clase `Object`.

La clase permite crear cuentas bancarias, realizar depósitos y retiros, y comparar cuentas mediante su número de cuenta.

## Design decisions

The `CuentaBancaria` class uses encapsulation by declaring its attributes as private, preventing direct access from outside the class.

The class protects the invariant that the account balance must always be greater than or equal to zero.

The constructors validate the initial balance so that an account cannot be created with an invalid negative balance.

The `depositar` and `retirar` methods validate their arguments and prevent operations that could violate the balance invariant.

The `equals` method defines two accounts as equal when they have the same account number, because the account number uniquely identifies the account.

The `hashCode` method uses the same account number as `equals`, which maintains the Java contract that equal objects must have the same hash code.

The `toString` method provides a readable textual representation of the account state, making the object easier to inspect and test.