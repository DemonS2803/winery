import * as React from "react";
import {
  Page,
  PageSection,
  Title,
  Form,
  FormGroup,
  TextInput,
  Button,
  Select,
  SelectOption
} from "@patternfly/react-core";
import {useEffect, useState} from "react";
import {backendApi} from "@app/utils/axios-config";
import {SelectBasic} from "@app/components/SelectBasic";

const AddInventorySection: React.FunctionComponent = () => {

  const [inventories, setInventories] = useState([])
  const [batches, setBatches] = useState([])
  const [isBatchDropdownOpen, setIsBatchDropdownOpen] = useState(true)
  const [newInventory, setNewInventory ] = useState({
    bottles: 0,
    batch: {}
  })

  useEffect(() => {
    const getStoreItemsListData = async () => {
      const result = await backendApi.get(`/inventory/available`)
      setInventories(result)
      console.log("inventory", result)
    }
    const getBatchsListData = async () => {
      const result = await backendApi.get(`/batch/all`)
      setBatches(result)
      console.log("batches", batches)
    }
    getBatchsListData()
    getStoreItemsListData()
  }, []);
  // @ts-ignore
  const handleAddInventory = () => {
    backendApi.post('/api/inventory', newInventory)
      .then(response => {
        console.log("success add ", response)
      })
      .catch(error => {
        console.error("Error adding inventory:", error);
      });
  };

  const handleUpdateBottles = (bottle) => {
    backendApi.put('/api/inventory', bottle)
      .then(() => {
        // setInventories(
        //   inventories.map(inv => inv.id === id ? { ...inv, bottles_available: bottlesAvailable } : inv)
        // );
      })
      .catch(error => {
        console.error("Error updating bottles:", error);
      });
  };

  // @ts-ignore
  return (
    <PageSection>
      <Title headingLevel="h1">Inventory Management</Title>
      <Form>
        <FormGroup label="Bottles Total" fieldId="bottles_total">
          <TextInput
            type="number"
            id="bottles_total"
            value={newInventory.bottles}
            // @ts-ignore
            onChange={(value) => setNewInventory({ ...newInventory, bottles: value })}
          />
        </FormGroup>
        <FormGroup label="Bottles Total" fieldId="bottles_total">
          <TextInput
            type="number"
            id="bottles_total"
            value={newInventory.bottles}
            // @ts-ignore
            onChange={(value) => setNewInventory({ ...newInventory, bottles: value })}
          />
        </FormGroup>

        {/* Dropdown for selecting Batch ID */}
        <FormGroup label="Batch ID" fieldId="batch_id">

          {/*<Select*/}
          {/*  id="batch_id"*/}
          {/*  isOpen={isBatchDropdownOpen}*/}
          {/*  // toggle={() => setIsBatchDropdownOpen(!isBatchDropdownOpen)}*/}
          {/*  onSelect={(event, value) => {*/}
          {/*    setNewInventory({ ...newInventory, batch: value });*/}
          {/*    setIsBatchDropdownOpen(false);*/}
          {/*  }}*/}
          {/*  placeholder={"select batch"}*/}
          {/*  // selections={newInventory.batch.id}*/}
          {/*>*/}
          {batches.map(batch => (
            <h1>batch {batch.id} {batch.wine.name}</h1>

          ))}
          {/*</Select>*/}
        </FormGroup>
        <Button variant="primary" onClick={handleAddInventory}>Add Inventory</Button>
      </Form>

      {/* Table for Current Inventories */}
      <Title headingLevel="h2" style={{ marginTop: '20px' }}>Current Inventories</Title>
      <table className="pf-c-table pf-m-grid-md" role="grid" aria-label="Inventory Table">
        <thead>
        <tr>
          <th>ID</th>
          <th>Bottles Available</th>
          <th>Bottles Total</th>
          <th>Batch ID</th>
          <th>Update Bottles</th>
        </tr>
        </thead>
        <tbody>
        {inventories.map((inventory) => (
          <tr key={inventory.id}>
            <td>{inventory.id}</td>
            <td>{inventory.bottlesAvailable}</td>
            <td>{inventory.bottlesTotal}</td>
            <td>{inventory.batchId}</td>
            <td>
              <TextInput
                type="number"
                value={inventory.bottlesAvailable}
                onChange={(value) => handleUpdateBottles(inventory)}
              />
            </td>
          </tr>
        ))}
        </tbody>
      </table>
    </PageSection>
  )
}

export { AddInventorySection };
