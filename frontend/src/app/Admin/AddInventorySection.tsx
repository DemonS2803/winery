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
  SelectOption,
  FormSelect,
  FormSelectOption,
  NumberInput
} from "@patternfly/react-core";
import {useEffect, useState} from "react";
import {backendApi} from "@app/utils/axios-config";
import {SelectBasic} from "@app/components/SelectBasic";

const AddInventorySection: React.FunctionComponent = () => {

  const [inventories, setInventories] = useState([])
  const [batches, setBatches] = useState([])
  const [newInventoryBatch, setNewInventoryBatch] = useState({})
  const [newInventoryBottles, setNewInventoryBottles] = useState(0)

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


  const onBottlesChange = (e, value) => {
    // @ts-ignore
    setNewInventoryBottles(value);
  };

  const onBatchChange = (_event: React.FormEvent<HTMLSelectElement>, value: any) => {
    console.log("new batch ", value)
    setNewInventoryBatch(value);
    console.log(newInventoryBatch)
  };

  const addNewInventory = () => {
    backendApi.post('/inventory', {
      wineName: newInventoryBatch,
      bottles: newInventoryBottles
    })
  }


  // @ts-ignore
  return (
    <PageSection>
      <Title headingLevel="h1">Inventory Management</Title>

      <FormSelect value={newInventoryBatch} onChange={onBatchChange} aria-label="FormSelect Input" ouiaId="BasicFormSelect" >
        {inventories.map((value) => (
          <FormSelectOption label={value.batch.wine.name} value={value.batch.wine.name} key={value.id} isDisabled={false}/>

        ))}
      </FormSelect>
      <TextInput type={'number'} value={newInventoryBottles} onChange={onBottlesChange}></TextInput>
      <Button onClick={addNewInventory}>Create</Button>

    </PageSection>
  )
}

export { AddInventorySection };


export const FormSelectBasic: React.FunctionComponent = () => {
  const [formSelectValue, setFormSelectValue] = React.useState('mrs');

  const onChange = (_event: React.FormEvent<HTMLSelectElement>, value: string) => {
    setFormSelectValue(value);
  };

  const options = [
    { value: 'please choose', label: 'Select one', disabled: true },
    { value: 'mr', label: 'Mr', disabled: false },
    { value: 'miss', label: 'Miss', disabled: false },
    { value: 'mrs', label: 'Mrs', disabled: false },
    { value: 'ms', label: 'Ms', disabled: false },
    { value: 'dr', label: 'Dr', disabled: false },
    { value: 'other', label: 'Other', disabled: false }
  ];

  return (
    <FormSelect value={formSelectValue} onChange={onChange} aria-label="FormSelect Input" ouiaId="BasicFormSelect">
      {options.map((option, index) => (
        <FormSelectOption isDisabled={option.disabled} key={index} value={option.value} label={option.label} />
      ))}
    </FormSelect>
  );
};
